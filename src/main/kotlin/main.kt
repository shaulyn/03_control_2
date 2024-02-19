import kotlin.math.max

const val ERROR_TYPE = -1
const val ERROR_LIMIT = -2

fun main(){
    println(comission("Mastercard", 25000, 40_000))

}

fun comission(cardType: String = "Мир", previous: Int = 0, transfer: Int ): Int{
    return  when(cardType) {
        "Mastercard" -> if(previous+transfer<=600_000 && transfer<=150_000) {
            if(previous >75000){
                (transfer * 0.006).toInt() + 20
            }else if(previous+transfer > 75000)  {
                ((transfer -75000) * 0.006).toInt() + 20
            }else{
                transfer
            }
        }else{
            ERROR_LIMIT
        }

        "Visa" -> if(previous+transfer<=600_000 && transfer<=150_000) {
            max(35, (transfer * 0.0075).toInt())
        }else{
            ERROR_LIMIT
        }
        "Мир" -> if(previous+transfer<=600_000 && transfer<=150_000) {
            transfer
        }else{
            ERROR_LIMIT
        }

        else -> ERROR_TYPE
    }
}