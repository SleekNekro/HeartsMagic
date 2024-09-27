package com.example.heartsmagic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.heartsmagic.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private var life1 : Int = 20
    private var life2 : Int =20
    private var poison1 = 0
    private var poison2 = 0

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Botones P1
        //Corazones
        binding.plusHeart1.setOnClickListener {
            life1++
            actuaizarP1()
        }
        binding.minusHeart1.setOnClickListener{
            life1--
            actuaizarP1()
        }
        //Poison
        binding.Pp1.setOnClickListener{
            poison1++
            actuaizarP1()
        }
        binding.Pm1.setOnClickListener{
            poison1--
            actuaizarP1()
        }
        //flecha
        binding.lifeP1toP2.setOnClickListener {
            life1--
            life2++
            actuaizarP1()
            actualizarP2()
        }
        //Botones P2
        //Corazones
        binding.plusHeart2.setOnClickListener {
            life2++
            actualizarP2()
        }
        binding.minusHeart2.setOnClickListener {
            life1--
            actualizarP2()
        }
        //Poison
        binding.Pp2.setOnClickListener {
            poison2++
            actualizarP2()
        }
        binding.Pm2.setOnClickListener {
            poison2--
            actualizarP2()
        }
        //flecha
        binding.lifeP2toP1.setOnClickListener {
            life2--
            life1++
            actuaizarP1()
            actualizarP2()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    //funciones
    private fun reset(){
        life1=20
        life2=20
        poison1=0
        poison2=0
        actuaizarP1()
        actualizarP2()
    }
    private fun actuaizarP1(){
        binding.textLife1.setText(""+life1+"/"+poison1)
    }
    private fun actualizarP2(){
        binding.textLife2.setText(""+life2+"/"+poison2)
    }
}