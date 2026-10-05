package com.example.fadly_3tib

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fadly_3tib.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Isi pilihan dropdown Program Studi
        val daftarProdi = listOf(
            "Teknik Informatika",
            "Sistem Informasi",
            "Teknik Komputer",
            "Teknik Elektro"
        )
        val adapterProdi = ArrayAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            daftarProdi
        )
        binding.actProdi.setAdapter(adapterProdi)

        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()
            val kelas = binding.etKelas.text.toString().trim()
            val nim = binding.etNim.text.toString().trim()
            val prodi = binding.actProdi.text.toString().trim()

            if (username.isEmpty() || password.isEmpty() || kelas.isEmpty() ||
                nim.isEmpty() || prodi.isEmpty()
            ) {
                Toast.makeText(this, "Semua kolom harus diisi!", Toast.LENGTH_SHORT).show()
            } else {
                val intent = Intent(this, MainActivity::class.java)
                intent.putExtra("username", username)
                intent.putExtra("password", password)
                intent.putExtra("kelas", kelas)
                intent.putExtra("nim", nim)
                intent.putExtra("prodi", prodi)
                startActivity(intent)
            }
        }
    }
}
