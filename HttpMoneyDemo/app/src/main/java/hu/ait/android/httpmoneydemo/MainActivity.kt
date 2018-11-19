package hu.ait.android.httpmoneydemo

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import com.google.gson.Gson
import hu.ait.android.httpmoneydemo.asynctask.HttpGetTask
import hu.ait.android.httpmoneydemo.data.MoneyResult
import hu.ait.android.httpmoneydemo.network.CurrencyAPI
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val HOST_URL = "https://api.exchangeratesapi.io/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val retrofit = Retrofit.Builder()
            .baseUrl(HOST_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val currencyAPI = retrofit.create(CurrencyAPI::class.java)
        val currencyRatesCall = currencyAPI.getRates("USD")

        btnRates.setOnClickListener {
            val currencyRatesCall = currencyAPI.getRates(etBase.text.toString())

            currencyRatesCall.enqueue(object : Callback<MoneyResult> {

                override fun onFailure(call: Call<MoneyResult>, t: Throwable) {
                    tvResult.text = t.message
                }

                override fun onResponse(call: Call<MoneyResult>, response: Response<MoneyResult>) {
                    val moneyResult = response.body()
                    tvResult.text =
                            "HUF: ${String.format("%.2f", moneyResult?.rates?.HUF?.toFloat())}"
                    tvResult.append(", EUR: ${moneyResult?.rates?.EUR}")
                }
            })
        }
    }

}
