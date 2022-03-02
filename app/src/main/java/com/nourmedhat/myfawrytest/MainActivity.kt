package com.nourmedhat.myfawrytest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.app.mylibrary.FawrySdk
import com.app.mylibrary.interfaces.FawryPreLaunch
import com.app.mylibrary.interfaces.FawrySdkCallbacks
import com.app.mylibrary.models.*
import com.app.mylibrary.utils.AppConstants
import com.app.mylibrary.utils.FawryUtils

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val chargeItems = ArrayList<PayableItem>()


        var customerEmail = "jhjhjh@asd.cm"
        var customerName = "nour medhat"
        var customerMobile = "01158656096"

        var cif = null
        val customerProfileId = ""
        val customerPassword = "P@ssw0rd"


//    val token=  "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiI1NTkzMTMxMTA3MTkyODUxNjQiLCJmcGEiOiIyMDAwMDAyNzAwIiwidXN0IjoiQ1VTVE9NRVIiLCJiZWkiOjQwMSwiaXNzIjoiZmF3cnkuY29tIiwiZXhwIjoxNjMzMzQ2NzczLCJpYXQiOjE2MzMzMzk1NzMsImp0aSI6ImVlNDk1NmI2LTQ0NDUtNGZlZC04N2RjLWZkOThhNmI4OTE0MCJ9._YfJjME5uIm3xAzmfQwBufEp4IfiGqjILHy7UTq1nqo"


        val token = ""


        //    var courier="DELIVERY"
        var courier = "PICKUP"
//    var courier="DINING_IN"
        var lang: FawrySdk.Languages = FawrySdk.Languages.ENGLISH
        //FawrySdk.init(FawrySdk.Styles.STYLE1);
        //FawrySdk.st

        val chargeItem3DSProduction = BillItems(
            itemId = "d5800a810fad4265a9bbd14fd0a7acdd",
            itemSKU = null,
            description = "test nour medhat",
            quantity = "10",
            earningRuleId = null,
            variantCode = "1234",
            price = "1000.00",
            originalPrice = "10.00",
            specialRequest = null,
            imageUrl = null,
            addons = null
        )
        chargeItems.add(chargeItem3DSProduction)
        FawrySdk.launchAnonymousSDK(
            this,
            lang,
            null,
            FawryLaunchModel(
                LaunchCustomerModel(
                    customerName = customerName,
                    customerEmail = customerEmail,
                    customerMobile = customerMobile,
                    customerProfileId = customerProfileId,
                    customerCif = null
                ),
                LaunchMerchantModel(
                    merchantCode = AppConstants.MERCHANT_ID,
                    merchantRefNum = FawryUtils.randomAlphaNumeric(10)

                ), allow3DPayment = true,
                secretCode = "af13d35226264f568b10d197abdc5972",
                chargeItems = chargeItems,
                shippingAddress = null,
                branchCode = null,
                serviceTypeCode = null,
                scheduledTime = null,
                skipReceipt = false,
                skipLogin = true
            ), object : FawrySdkCallbacks {
                override fun onPreLaunch(onPreLaunch: FawryPreLaunch) {
                    onPreLaunch.onContinue()
                }

                override fun onInit() {

                }

                override fun onSuccess(msg: String, data: Any?) {
                    Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
                    Log.d("test", msg.toString())

                }

                override fun onFailure(error: String) {
                    Log.d("test", error.toString())
                    Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()
                }
            })
    }


}