package com.example.aspas_design

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.aspas_design.databinding.ActivityOtpBinding
import com.example.aspas_design.databinding.ActivitySignUpBinding

const val CORRECT_OTP = 1234
const val OTP_LENGTH = 4
class OtpActivity : AppCompatActivity() {

    private lateinit var binding: ActivityOtpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.otpEDT.addTextChangedListener(object : TextWatcher {

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
                if (s.length == OTP_LENGTH) {
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
            val enteredOtp = binding.otpEDT.text.toString()
            if(checkotp(enteredOtp))
            {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
            else
            {
                Toast.makeText(this,"Oppsie! Incorrect OTP",Toast.LENGTH_SHORT).show()
            }
        }



        binding.backutton.setOnClickListener {
            finish()
        }


    }

    private fun checkotp(enteredOtp: String): Boolean {
        return enteredOtp == CORRECT_OTP.toString()
    }
}