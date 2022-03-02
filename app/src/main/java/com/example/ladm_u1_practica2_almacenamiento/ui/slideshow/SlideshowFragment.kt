package com.example.ladm_u1_practica2_almacenamiento.ui.slideshow

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ladm_u1_practica2_almacenamiento.CustomAdapter
import com.example.ladm_u1_practica2_almacenamiento.R
import com.example.ladm_u1_practica2_almacenamiento.databinding.FragmentSlideshowBinding
import com.example.ladm_u1_practica2_almacenamiento.Arreglo.registro1
import com.example.ladm_u1_practica2_almacenamiento.Arreglo.registro2
import com.example.ladm_u1_practica2_almacenamiento.Arreglo.registro3
import com.example.ladm_u1_practica2_almacenamiento.Arreglo.registro4
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

class SlideshowFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val slideshowViewModel =
            ViewModelProvider(this).get(SlideshowViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val recyclerView = binding.recyclerView.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = CustomAdapter()

        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter

        binding.fab.setOnClickListener { view ->
            //guardarArchivo()
        }

        return root
    }

  /*  private fun guardarArchivo() {
        try {
            val archivo = OutputStreamWriter(openFileOutput("archivo.txt",
                AppCompatActivity.MODE_PRIVATE
            ))
            var espacio = registro1.size-1
            var cadena1 = " "
            (0..espacio).forEach{
                if(it == espacio){
                    cadena1 += registro1[it]+"||"+registro2[it]+"||"+registro3[it]+"||"+registro4[it]
                }
                cadena1 += registro1[it]+"||"+registro2[it]+"||"+registro3[it]+"||"+registro4[it]+"&&"
                Toast.makeText(this, "${cadena1}", Toast.LENGTH_LONG).show()
            }
            archivo.write(cadena1)
            archivo.flush()
            archivo.close()
            androidx.appcompat.app.AlertDialog.Builder(this).setMessage("TU ARCHIVO FUE GUARDADO").show()
        }catch (e:Exception){
            androidx.appcompat.app.AlertDialog.Builder(this).setMessage(e.message).show()
        }
    }

    private fun leerArchivo() {
        try {
            val archivo = BufferedReader(InputStreamReader(openFileInput("archivo.txt")))
            var listaContenido = archivo.readLine()//archivo de tipo list
            val dividir = listaContenido.split("&&")
            (0..dividir.size).forEach {
                var cadena2 = dividir[it].split("||")
                registro1[it]=cadena2[0]
                registro2[it]=cadena2[1]
                registro3[it]=cadena2[2]
                registro4[it]=cadena2[3]
            }

            AlertDialog.Builder(this)
                .setMessage(listaContenido.toString()).show()
        }catch (e: Exception){
            AlertDialog.Builder(this)
                .setMessage(e.message).show()
        }
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}