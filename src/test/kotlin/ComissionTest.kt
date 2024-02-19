import org.junit.Test
import kotlin.test.assertEquals

class ComisionTest {

    @Test
    fun testVisa(){
        val type = "Visa"
        val previous = 0
        val transfer = 1000

        val result = comission(cardType = type, previous = previous, transfer=transfer)

        assertEquals(35, result)
    }

    @Test
    fun testVisaLimit(){
        val type = "Visa"
        val previous = 0
        val transfer = 1000_000

        val result = comission(cardType = type, previous = previous, transfer=transfer)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testVisaDayLimit(){
        val type = "Visa"
        val previous = 0
        val transfer = 200_000

        val result = comission(cardType = type, previous = previous, transfer=transfer)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testMastercardLimit1(){
        val type = "Mastercard"
        val previous = 80_000
        val transfer = 100_000

        val result = comission(cardType = type, previous = previous, transfer=transfer)

        assertEquals(620, result)
    }

    @Test
    fun testMastercardLimit2(){
        val type = "Mastercard"
        val previous = 50_000
        val transfer = 100_000

        val result = comission(cardType = type, previous = previous, transfer=transfer)

        assertEquals(170, result)
    }

    @Test
    fun testMastercardLimit3(){
        val type = "Mastercard"
        val previous = 0
        val transfer = 50_000

        val result = comission(cardType = type, previous = previous, transfer=transfer)

        assertEquals(50000, result)
    }

    @Test
    fun testMastercardLimit4(){
        val type = "Mastercard"
        val previous = 0
        val transfer = 50_000

        val result = comission(cardType = type, previous = previous, transfer=transfer)

        assertEquals(60000, result)
    }



    @Test
    fun testMastercardLimit(){
        val type = "Mastercard"
        val previous = 0
        val transfer = 1000000

        val result = comission(cardType = type, previous = previous, transfer=transfer)

        assertEquals(ERROR_LIMIT, result)
    }

    @Test
    fun testMirLimit(){
        val type = "Мир"
        val previous = 0
        val transfer = 1000000

        val result = comission(cardType = type, previous = previous, transfer=transfer)

        assertEquals(ERROR_LIMIT, result)
    }
    @Test
    fun testMirTransfer(){
        val type = "Мир"
        val previous = 0
        val transfer = 100000

        val result = comission(cardType = type, previous = previous, transfer=transfer)

        assertEquals(100000, result)
    }
    @Test
    fun testMirTransfer2(){
        val type = "Мир"
        val previous = 300000
        val transfer = 100000

        val result = comission(cardType = type, previous = previous, transfer=transfer)

        assertEquals(100000, result)
    }

    @Test
    fun testMirTransfer3(){

        val previous = 300000
        val transfer = 100000

        val result = comission(previous = previous, transfer=transfer)

        assertEquals(100000, result)
    }


    @Test
    fun testWrongType(){
        val type = "Visa1"
        val previous = 0
        val transfer = 1000000

        val result = comission(cardType = type, previous = previous, transfer=transfer)

        assertEquals(ERROR_TYPE, result)
    }
}