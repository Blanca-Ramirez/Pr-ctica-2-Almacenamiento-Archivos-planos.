package com.example.ladm_u1_practica2_almacenamiento.ui.gallery

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ladm_u1_practica2_almacenamiento.databinding.FragmentGalleryBinding
import kotlinx.android.synthetic.main.fragment_gallery.*
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.lang.Exception

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

        binding.registrar.setOnClickListener {
            guardarEnArchivo()
        }

        binding.leer.setOnClickListener {
            leerDesdeArchivo()
        }

        return root
    }

    private fun leerDesdeArchivo() {
        try {
            val archivo = InputStreamReader(requireActivity().openFileInput("archivo.txt"))
            var listaContenido = archivo.readLines()

            //binding.pelicula.setText(listaContenido.get(0))
            //binding.invitado.setText(listaContenido.get(4))
            //binding.total.setText(listaContenido.get(5))

            AlertDialog.Builder(requireContext())
                .setMessage(listaContenido.toString()).show()

        }catch (e:Exception){
            AlertDialog.Builder(requireContext())
                .setMessage(e.message).show()
        }
    }

    private fun guardarEnArchivo() {
        try {
            val archivo = OutputStreamWriter(requireActivity().openFileOutput("archivo.txt",0))

            var cadena2 = ""
            if(comida1.isChecked){
                cadena2+=" PALOMITAS "
            }
            if(comida2.isChecked){
                cadena2+=" REFRESCOS "
            }
            if(comida3.isChecked){
                cadena2+=" DULCES "
            }

            var cadena = binding.pelicula.text.toString()+"\n"+
                    cadena2+"\n"+
                    binding.invitado.text.toString()+"\n"+
                    binding.total.text.toString()
            archivo.write(cadena)
            archivo.flush()
            archivo.close()

            binding.pelicula.setText("")
            binding.invitado.setText("")
            binding.total.setText("")

            AlertDialog.Builder(requireContext())
                .setMessage("SE GUARDO CORRECTAMENTE").show()

        }catch (e:Exception){
            AlertDialog.Builder(requireContext())
                .setMessage(e.message).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}