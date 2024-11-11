import android.os.Parcel
import android.os.Parcelable

data class ItemCarrinho(
    val nome: String,
    val preco: String,
    val imagemResId: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString() ?: "",  // Lê o nome do parcel
        parcel.readString() ?: "",  // Lê o preço do parcel
        parcel.readInt()            // Lê o recurso da imagem do parcel
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nome)     // Escreve o nome no parcel
        parcel.writeString(preco)    // Escreve o preço no parcel
        parcel.writeInt(imagemResId) // Escreve a imagem no parcel
    }

    override fun describeContents(): Int {
        return 0 // Geralmente, você pode retornar 0 aqui
    }

    companion object CREATOR : Parcelable.Creator<ItemCarrinho> {
        override fun createFromParcel(parcel: Parcel): ItemCarrinho {
            return ItemCarrinho(parcel) // Cria um novo ItemCarrinho a partir do parcel
        }

        override fun newArray(size: Int): Array<ItemCarrinho?> {
            return arrayOfNulls(size) // Cria um array de ItemCarrinho
        }
    }
}
