import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context?) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        // Criação da tabela
        val createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EMAIL + " TEXT, " +
                COLUMN_PASSWORD + " TEXT)"
        db.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)
    }

    // Método para inserir um novo usuário
    fun insertUser(email: String?, password: String?): Boolean {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(COLUMN_EMAIL, email)
        values.put(COLUMN_PASSWORD, password)
        val result = db.insert(TABLE_NAME, null, values)
        return result != -1L // Retorna true se inserção for bem-sucedida
    }

    // Método para verificar o login do usuário
    fun checkUser(email: String, password: String): Boolean {
        val db = this.readableDatabase
        val cursor = db.query(
            TABLE_NAME, arrayOf(COLUMN_ID),
            COLUMN_EMAIL + "=? AND " + COLUMN_PASSWORD + "=?",
            arrayOf(email, password), null, null, null
        )
        val userExists = cursor.count > 0
        cursor.close()
        return userExists
    }

    companion object {
        private const val DATABASE_NAME = "UserDatabase.db"
        private const val DATABASE_VERSION = 1

        // Nome da tabela e colunas
        private const val TABLE_NAME = "users"
        private const val COLUMN_ID = "id"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_PASSWORD = "password"
    }
}