package com.zainul.buildrrr.mainclient.ui.obat

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.zainul.buildrrr.databinding.ActivityDetail2Binding
import com.zainul.buildrrr.mainclient.Home
import kotlinx.android.synthetic.main.activity_detail2.*


class Detail2 : AppCompatActivity() {

    private lateinit var binding: ActivityDetail2Binding
    private lateinit var auth: FirebaseAuth
    private lateinit var firebaseStorage: FirebaseStorage
    private lateinit var database: DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = ActivityDetail2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        firebaseStorage = FirebaseStorage.getInstance()
        database = Firebase.database.reference


        binding.imageView33.setOnClickListener {
            val home = Intent(this, Home::class.java)
            startActivity(home)
        }
        binding.pemesanan.setOnClickListener {
            val home = Intent(this, Home::class.java)
            startActivity(home)
        }
        database.child("Postingan Developer").child("ImGpdRmwz5OOXqWFdpIsxg5RdKZ2").get()
            .addOnSuccessListener {
                if (it.exists()) {
                    val bunga = it.child("inpbunga").value

                    binding.Persen.text = bunga.toString()
                }
                Log.i("firebase", "Data Ditemukan ${it.value}")
            }.addOnFailureListener {
                Log.e("firebase", "Gagal Memuat Data")
            }
        database.child("Postingan Developer").child("ImGpdRmwz5OOXqWFdpIsxg5RdKZ2").get()
            .addOnSuccessListener {
                if (it.exists()) {
                    val deskripsi = it.child("inpdeskripsi").value

                    binding.Deskripsi.text = deskripsi.toString()
                }
                Log.i("firebase", "Data Ditemukan ${it.value}")
            }.addOnFailureListener {
                Log.e("firebase", "Gagal Memuat Data")
            }
        database.child("Postingan Developer").child("ImGpdRmwz5OOXqWFdpIsxg5RdKZ2").get()
            .addOnSuccessListener {
                if (it.exists()) {
                    val detail = it.child("inpdetail").value

                    binding.Detail.text = detail.toString()
                }
                Log.i("firebase", "Data Ditemukan ${it.value}")
            }.addOnFailureListener {
                Log.e("firebase", "Gagal Memuat Data")
            }
        database.child("Postingan Developer").child("ImGpdRmwz5OOXqWFdpIsxg5RdKZ2").get()
            .addOnSuccessListener {
                if (it.exists()) {
                    val tipe = it.child("inptipe").value

                    binding.TipeRumah.text = tipe.toString()
                }
                Log.i("firebase", "Data Ditemukan ${it.value}")
            }.addOnFailureListener {
                Log.e("firebase", "Gagal Memuat Data")
            }
        database.child("Data Developer").child("ImGpdRmwz5OOXqWFdpIsxg5RdKZ2").get()
            .addOnSuccessListener {
                if (it.exists()) {
                    val namaperusahhan = it.child("datanama").value

                    binding.NamaPerusahaan.text = namaperusahhan.toString()
                }
                Log.i("firebase", "Data Ditemukan ${it.value}")
            }.addOnFailureListener {
                Log.e("firebase", "Gagal Memuat Data")
            }
        database.child("Postingan Developer").child("ImGpdRmwz5OOXqWFdpIsxg5RdKZ2").get()
            .addOnSuccessListener {
                if (it.exists()) {
                    val alamat = it.child("inplokasi").value

                    binding.Alamat.text = alamat.toString()
                }
                Log.i("firebase", "Data Ditemukan ${it.value}")
            }.addOnFailureListener {
                Log.e("firebase", "Gagal Memuat Data")
            }
        database.child("Postingan Developer").child("ImGpdRmwz5OOXqWFdpIsxg5RdKZ2").get()
            .addOnSuccessListener {
                if (it.exists()) {
                    val harga = it.child("inpharga").value

                    binding.Harga.text = harga.toString()
                }
                Log.i("firebase", "Data Ditemukan ${it.value}")
            }.addOnFailureListener {
                Log.e("firebase", "Gagal Memuat Data")
            }
        getImage()
    }

    private fun getImage() {
        val databaseReference =
            FirebaseDatabase.getInstance().getReference("Postingan Developer")
        databaseReference.child("ImGpdRmwz5OOXqWFdpIsxg5RdKZ2").get()
            .addOnSuccessListener {
                val image1 = it.child("image").value.toString()

                Glide.with(this).load(image1).into(image)
            }
    }
}