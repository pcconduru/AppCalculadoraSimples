package com.example.appcalculadorasimples

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appcalculadorasimples.databinding.ActivityMainBinding
import java.math.BigDecimal
import java.math.BigInteger

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate( layoutInflater )
    }
    private lateinit var valorX : BigDecimal
    private lateinit var valorY : BigDecimal
    internal var estadoX : Boolean = false
    internal var estadoY : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    

    class operacoes{
        fun somar(x: BigDecimal, y: BigDecimal) = { x + y }
        fun subtrair(x: BigDecimal, y: BigDecimal) = { x - y }
    }
}