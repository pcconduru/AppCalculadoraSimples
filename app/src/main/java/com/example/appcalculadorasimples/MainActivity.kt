package com.example.appcalculadorasimples

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appcalculadorasimples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }


    private var operacaoAberta = StringBuilder()
    private lateinit var ultimaOperacao : String
    private lateinit var operador : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var total : Int = 0

        binding.btnClear.setOnClickListener {
            operacaoAberta.clear()
            ultimaOperacao = operacaoAberta.toString()
        }
        binding.btnEquals.setOnClickListener {

            var calcUltima = ultimaOperacao.toInt()
            var calcAtual = operacaoAberta.toString().toInt()

            when (operador){
                "somar" -> total = calcUltima + calcAtual
                "subtrair" -> total = calcUltima - calcAtual
                "dividir" -> total = calcUltima / calcAtual
                "multiplicar" -> total = calcUltima * calcAtual
            }

            binding.txtCalculo.setText(total.toString())

            calcUltima = total
        }
    }

    fun operacaoClick(view: View){
        var pegarOperacaoId = view.context.resources.getResourceEntryName(view.id)
        ultimaOperacao = operacaoAberta.toString()
        operacaoAberta.clear()

        when ( pegarOperacaoId ){
            "btnAdd" -> operador = "somar"
            "btnDivider" -> operador = "dividir"
            "btnSubtract" -> operador = "subtrair"
            "btnTimes" -> operador = "multiplicar"
        }
    }

    fun numeroClick(view: View){
        var pegarNumeroId = view.context.resources.getResourceEntryName(view.id)
        when ( pegarNumeroId ){
            "btn0" -> operacaoAberta.append("0")
            "btn1" -> operacaoAberta.append("1")
            "btn2" -> operacaoAberta.append("2")
            "btn3" -> operacaoAberta.append("3")
            "btn4" -> operacaoAberta.append("4")
            "btn5" -> operacaoAberta.append("5")
            "btn6" -> operacaoAberta.append("6")
            "btn7" -> operacaoAberta.append("7")
            "btn8" -> operacaoAberta.append("8")
            "btn9" -> operacaoAberta.append("9")
        }
        binding.txtCalculo.setText(operacaoAberta)
    }

}