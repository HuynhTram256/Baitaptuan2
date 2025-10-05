package com.example.tentuoiapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var edtName: EditText
    private lateinit var edtAge: EditText
    private lateinit var btnCheck: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Ánh xạ view
        edtName = findViewById(R.id.edtName)
        edtAge = findViewById(R.id.edtAge)
        btnCheck = findViewById(R.id.btnCheck)
        tvResult = findViewById(R.id.tvResult)

        // Xử lý khi nhấn nút "Kiểm tra"
        btnCheck.setOnClickListener {
            val name = edtName.text.toString().trim()
            val ageStr = edtAge.text.toString().trim()

            if (name.isEmpty() || ageStr.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val age = ageStr.toIntOrNull()
            if (age == null) {
                Toast.makeText(this, "Tuổi phải là số!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val category = when {
                age > 65 -> "Người già"
                age >= 18 -> "Người lớn"
                age >= 6 -> "Trẻ em"
                else -> "Em bé"
            }

            val result = "Họ tên: $name\nTuổi: $age\nPhân loại: $category"
            tvResult.text = result
        }
    }
}
