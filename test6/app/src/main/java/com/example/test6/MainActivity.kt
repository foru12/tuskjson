package com.example.test6



import android.app.AlertDialog
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.test6.Adapter.Adapter
import com.example.test6.model.MainActivitiViewModel
import dmax.dialog.SpotsDialog
import okhttp3.internal.http2.Http2Reader.*


class MainActivity : AppCompatActivity() {

    private lateinit var handler: Handler
    private lateinit var runnable: Runnable
    private lateinit var mainActivityViewModel: MainActivitiViewModel
    private lateinit var rvAdapter: Adapter
    private var alertDialog: AlertDialog? = null
    private lateinit var Refresh : SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        refresh()
    }
    fun refresh(){
        Refresh = findViewById(R.id.swipeRefreshLayout)
        handler = Handler()
        Refresh.setOnRefreshListener {
            runnable = Runnable {
                Refresh.isRefreshing = false
            }

            handler.postDelayed(
                runnable, 1000.toLong()
            )
        }
    }
    fun init(){
        mainActivityViewModel = ViewModelProvider(this)[MainActivitiViewModel::class.java]
        alertDialog = SpotsDialog.Builder()
            .setCancelable(false)
            .setContext(this)
            .build()
        alertDialog!!.show()

        rvAdapter = Adapter()
        val rv = findViewById<RecyclerView>(R.id.ResView)
        rv.adapter = rvAdapter
        rv.layoutManager = GridLayoutManager(this@MainActivity,2)

        mainActivityViewModel.urlList.observe(this){
            if (it != null) {
                rvAdapter.setData(it)
                alertDialog?.dismiss()

            }
        }
    }

}


