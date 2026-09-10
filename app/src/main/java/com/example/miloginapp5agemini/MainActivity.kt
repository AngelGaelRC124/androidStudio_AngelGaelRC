package com.example.miloginapp5agemini

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.miloginapp5agemini.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Inicializar ViewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        setupLoginButton()
    }

    private fun setupLoginButton() {
        binding.btnLogin.setOnClickListener {
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (validateFields(username, password)) {
                // Simulación de validación exitosa
                Toast.makeText(this, "ingresaste las credenciales correctas", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun validateFields(user: String, pass: String): Boolean {
        if (user.isEmpty()) {
            binding.etUsername.error = "El usuario es requerido"
            return false
        }
        if (pass.isEmpty()) {
            binding.etPassword.error = "La contraseña es requerida"
            return false
        }
        return true
    }
}