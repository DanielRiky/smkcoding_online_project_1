package com.example.chalenge1

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_profil.*

class ProfilActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profil)

        ambilData()
        btnedit.setOnClickListener { navigasiKeEditProfil() }
        btndial.setOnClickListener { dialPhone((txttelp.text.toString()))}
        btnabout.setOnClickListener { about() }
    }

    private fun about(){
        val intent = Intent(this, AboutActivity::class.java)
        startActivity(intent)
    }

    private fun ambilData(){
        val bundle = intent.extras
        val nama = bundle.getString("nama")
        val jk = bundle.getString("jk")
        val umur = bundle.getString("umur")
        val email = bundle.getString("email")
        val telp = bundle.getString("no")
        val alamat = bundle.getString("alamat")

        txtnama.text = nama
        txtalamat.text = alamat
        txtemail.text = email
        txttelp.text = telp
        txtumur.text = umur
        txtjk.text = jk
    }

    private fun dialPhone(phoneNumber: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNumber")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    companion object {
        val REQUEST_CODE = 100
    }

    private fun navigasiKeEditProfil() {
        val intent = Intent(this, EditActivity::class.java)
        val namaUser = txtnama.text.toString()

        intent.putExtra("nama", namaUser)

        startActivityForResult(intent, REQUEST_CODE)
    }
    @SuppressLint("MissingSuperCall")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data:
    Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE){
            if (resultCode == Activity.RESULT_OK) {
                val result1 = data?.getStringExtra("nama")

                txtnama.text = result1

            }else{
                Toast.makeText(this, "Edit failed",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }
}
