package com.example.chalenge1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var edtnama: EditText
    private lateinit var spinerjk: Spinner
    private lateinit var edtumur: EditText
    private lateinit var edtemail: EditText
    private lateinit var edtno: EditText
    private lateinit var edtalamat: EditText
    private lateinit var btnsave: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        edtnama = findViewById(R.id.edtnama)
        spinerjk = findViewById(R.id.spinerjk)
        edtumur = findViewById(R.id.edtumur)
        edtemail = findViewById(R.id.edtemail)
        edtno = findViewById(R.id.edtno)
        edtalamat = findViewById(R.id.edtalamat)
        btnsave = findViewById(R.id.btnsave)
        btnsave.setOnClickListener { validasi() }
    }

//    private fun setDataSpinnerGender() {
//        val adapter = ArrayAdapter.createFromResource(
//            this,
//            R.array.jenis_kelamin, android.R.layout.simple_spinner_item
//        )
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//        spinerjk.adapter = adapter
//    }

    private fun goToProfil() {
        val intent = Intent(this, ProfilActivity::class.java)
        val bundle = Bundle()
        bundle.putString("nama", namaIn)
        bundle.putString("umur", umurIn)
        bundle.putString("jk", jkIn)
        bundle.putString("email", emailIn)
        bundle.putString("no", telpIn)
        bundle.putString("alamat", alamatIn)
        intent.putExtras(bundle)
        startActivity(intent)
    }

    private var namaIn: String = ""
    private var umurIn: String = ""
    private var emailIn: String = ""
    private var telpIn: String = ""
    private var alamatIn: String = ""
    private var jkIn: String = ""

    private fun validasi() {
        namaIn = edtnama.text.toString()
        umurIn = edtumur.text.toString()
        emailIn = edtemail.text.toString()
        telpIn = edtno.text.toString()
        alamatIn = edtalamat.text.toString()
        jkIn = spinerjk.selectedItem.toString()
        when {
            namaIn.isEmpty() -> edtnama.error = "Nama tidak boleh kosong"

            jkIn.equals(
                "Pilih Jenis Kelamin",
                ignoreCase = true
            ) -> tampilToast("Jenis Kelamin harus dipilih")
            umurIn.isEmpty() -> edtumur.error = "Umur tidak boleh kosong"
            emailIn.isEmpty() -> edtemail.error = "Email tidak boleh kosong"
            telpIn.isEmpty() -> edtno.error = "No Telepon tidak boleh kosong"
            alamatIn.isEmpty() -> edtalamat.error = "Alamat tidak boleh kosong"
            else -> {
                tampilToast("Navigasi ke halaman profil")
                goToProfil()

            }
        }

    }

    private fun tampilToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}


