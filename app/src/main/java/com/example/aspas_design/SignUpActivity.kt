package com.example.aspas_design

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.example.aspas_design.databinding.ActivitySignUpBinding

const val NUMBER_LENGTH = 10

class SignUpActivity : AppCompatActivity() {


    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.phoneNumberEDT.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {

            }

            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }

            @SuppressLint("ResourceAsColor")
            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                if (s.length == NUMBER_LENGTH) {
                    binding.nextButton.isEnabled = true
                    binding.nextButton.setBackgroundResource(R.drawable.edt_bg_actv)
                    binding.nextButton.setTextColor(
                        getApplication().getResources().getColor(R.color.white)
                    )
                } else {
                    binding.nextButton.isEnabled = false
                    binding.nextButton.setBackgroundResource(R.drawable.button_bg)
                    binding.nextButton.setTextColor(
                        getApplication().getResources().getColor(R.color.bg_text)
                    )
                }
            }
        })


        binding.nextButton.setOnClickListener {
            val intent = Intent(this, OtpActivity::class.java)
            startActivity(intent)
        }


    }
}