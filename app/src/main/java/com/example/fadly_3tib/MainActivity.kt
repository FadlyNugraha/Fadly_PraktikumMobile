package com.example.fadly_3tib

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fadly_3tib.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Ambil data dari LoginActivity
        val user = intent.getStringExtra("username")
        val pass = intent.getStringExtra("password")
        val umur = intent.getIntExtra("umur", 0)
        val nim = intent.getStringExtra("nim")
        val prodi = intent.getStringExtra("prodi")

        Log.v("Hasil", "umur $umur, nim $nim, prodi $prodi")

        binding.txtSapaan.text = "Halo, $user!"
        binding.txtUsername.text = user
        binding.txtPassword.text = pass
        binding.txtUmur.text = umur.toString()
        binding.txtNim.text = nim
        binding.txtProdi.text = prodi

        // Snackbar
        binding.btnSnackBar.setOnClickListener {
            Snackbar.make(binding.root, "Item dihapus", Snackbar.LENGTH_LONG)
                .setAction("BATAL") {
                    Toast.makeText(this, "Penghapusan dibatalkan", Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        // Alert Dialog
        binding.btnAlertDialog.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Konfirmasi")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { _, _ ->
                    finish()
                }
                .setNegativeButton("Tidak") { dialog, _ ->
                    dialog.dismiss()
                }
                .show()
        }

        // Tombol Kembali
        binding.btnKembali.setOnClickListener {
            finish()
        }
    }
}