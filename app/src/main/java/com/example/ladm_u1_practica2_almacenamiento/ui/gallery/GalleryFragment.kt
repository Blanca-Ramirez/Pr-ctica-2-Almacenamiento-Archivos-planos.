package com.example.ladm_u1_practica2_almacenamiento.ui.gallery

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ladm_u1_practica2_almacenamiento.Arreglo.i
import com.example.ladm_u1_practica2_almacenamiento.databinding.FragmentGalleryBinding
import kotlinx.android.synthetic.main.fragment_gallery.*
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception
import com.example.ladm_u1_practica2_almacenamiento.Arreglo.registro1
import com.example.ladm_u1_practica2_almacenamiento.Arreglo.registro2
import com.example.ladm_u1_practica2_almacenamiento.Arreglo.registro3
import com.example.ladm_u1_practica2_almacenamiento.Arreglo.registro4
import com.example.ladm_u1_practica2_almacenamiento.Arreglo.y
import com.example.ladm_u1_practica2_almacenamiento.Arreglo.z

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.insertar.setOnClickListener {
            insertarRegistro()
        }

        binding.eliminar.setOnClickListener {
            eliminarRegistro()
        }

        binding.actualizar.setOnClickListener {
            actualizarRegistro()
        }

        return root
    }

    private fun eliminarRegistro() {
        try{
            y=0
            z--
            val espacio = registro1.size-1
            (0..espacio).forEach {
                if(orden.text.toString().equals(registro2[it])){
                    i=it
                    registro1[it]=""
                    registro2[it]=""
                    registro3[it]=""
                    registro4[it]=""
                    y=1
                }
            }
            if(y==0){
                AlertDialog.Builder(requireContext())
                    .setTitle("NO EXISTE LA ORDEN")
                    .setPositiveButton("ACEPTAR",{d, i->d.dismiss()})
                    .setNegativeButton("SALIR", {d, i->d.cancel()})
                    .show()
            }
            binding.pelicula.setText("")
            binding.orden.setText("")
            binding.invitado.setText("")
            binding.total.setText("")
            Toast.makeText(requireContext(), "LA COMPRA SE ELIMINO", Toast.LENGTH_LONG).show()
        }catch (e:Exception){
            AlertDialog.Builder(requireContext())
                .setMessage(e.message)
                .show()
        }
    }

    private fun actualizarRegistro() {
        try {
            y=0
            val espacio = registro1.size-1
            (0..espacio).forEach {
                if(orden.text.toString().equals(registro2[it])) {
                    registro1[it] = binding.pelicula.text.toString()
                    registro2[it] = binding.orden.text.toString()
                    registro3[it] = binding.invitado.text.toString()
                    registro4[it] = binding.total.text.toString()
                    y=1
                }
            }
            if(y==0){
                AlertDialog.Builder(requireContext())
                    .setTitle("LA ORDEN NO EXISTE")
                    .setPositiveButton("ACEPTAR",{d, i->d.dismiss()})
                    .setNegativeButton("SALIR", {d, i->d.cancel()})
                    .show()
            }
            binding.pelicula.setText("")
            binding.orden.setText("")
            binding.invitado.setText("")
            binding.total.setText("")
            Toast.makeText(requireContext(), "LA COMPRA SE ACTUALIZO", Toast.LENGTH_LONG).show()
        }catch (e:Exception){
            AlertDialog.Builder(requireContext())
                .setMessage(e.message)
                .show()
        }
    }

    private fun insertarRegistro() {
        try {
            y=0
            val espacio = registro1.size-1
            (0..espacio).forEach {
                if (registro3[it].isEmpty() && y == 0) {
                    registro1[it] = binding.pelicula.text.toString()
                    registro2[it] = binding.orden.text.toString()
                    registro3[it] = binding.invitado.text.toString()
                    registro4[it] = binding.total.text.toString()
                    y=1
                }
            }

        }catch (e:Exception){
            AlertDialog.Builder(requireContext())
                .setMessage(e.message)
                .show()
        }
        binding.pelicula.setText("")
        binding.orden.setText("")
        binding.invitado.setText("")
        binding.total.setText("")
        Toast.makeText(requireContext(), "SU COMPRA SE REGISTRO CORRECTAMENTE", Toast.LENGTH_LONG).show()
        }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
