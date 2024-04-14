package com.example.menutest.ui.photos

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.menutest.R
import com.example.menutest.databinding.FragmentPhotoBinding
import com.google.android.material.snackbar.Snackbar

class PhotoFragment : Fragment() {

    // cambiar el FragmentHomeBinding  a FragmentProfileBinding
    private var _binding: FragmentPhotoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(PhotoViewModel::class.java)

        _binding = FragmentPhotoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }


        val listViewcantantes: ListView = binding.listViewcantantes
        val cantanteslist = arrayOf(
            Cantantes("Selena Gomez", R.drawable.celenagomez),
            Cantantes("Ariana Grande",R.drawable.ariana),
            Cantantes("Beyoncé",R.drawable.beyonce),
            Cantantes("Justin Bieber",R.drawable.justin),
            Cantantes("Taylor Swift",R.drawable.taylor)
        )
        val adapter = ArrayAdapter(binding.root.context,R.layout.list_item_layout, R.id.txtDescription, cantanteslist)
        listViewcantantes.adapter = adapter

        // Manejar clics en los elementos de la lista
        listViewcantantes.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->

               var viewitem= view.findViewById<TextView>(R.id.txtDescription);
                val image =  view.findViewById<ImageView>(R.id.imageView)
                image.setImageResource(cantanteslist[position].imageResId)
                Snackbar.make(view, "Hizo clic en el item "+ position +" cantante:"+viewitem.text , Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .setAnchorView(R.id.fab).show()
            }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


data class Cantantes(val title: String, val imageResId: Int) {
    override fun toString(): String {
        return title
    }
}