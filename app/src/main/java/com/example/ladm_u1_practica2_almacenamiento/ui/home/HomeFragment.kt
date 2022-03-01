package com.example.ladm_u1_practica2_almacenamiento.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.ladm_u1_practica2_almacenamiento.R
import com.example.ladm_u1_practica2_almacenamiento.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val btnacerca = binding.acerca
        btnacerca.setOnClickListener{
            val imagen = ImageView(requireContext())
            imagen.setImageResource(R.drawable.icono1)

            AlertDialog.Builder(requireContext())
                .setTitle("Hola! ¿Como haz estado?")
                .setMessage("Buscanos en Facebook para saber mas de nosotros")
                .setView(imagen)
                .setPositiveButton("OK",{d,i->})
                .show()

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}