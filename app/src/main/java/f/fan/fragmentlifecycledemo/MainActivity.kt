package f.fan.fragmentlifecycledemo

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //show hide demo
        btnSH?.setOnClickListener {
            startActivity(Intent(this@MainActivity, ShowHideDemoActivity::class.java))
        }


        btnVP?.setOnClickListener {
            startActivity(Intent(this@MainActivity, ViewPagerDemoActivity::class.java))
        }

    }



}
