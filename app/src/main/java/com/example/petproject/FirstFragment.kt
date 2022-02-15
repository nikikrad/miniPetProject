package com.example.petproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.petproject.databinding.FragmentFirstBinding
import com.example.petproject.servises.Person
import com.example.petproject.servises.Person.personsList

class FirstFragment : Fragment() {

    lateinit var binding: FragmentFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        Person.start()
//        Thread.sleep(5000)
        Toast.makeText(context, "hi", Toast.LENGTH_SHORT).show()
        val personAdapter = PersonAdapter(personsList)
        binding.rvPersons.layoutManager = LinearLayoutManager(activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
        binding.rvPersons.adapter = personAdapter

    }

    override fun onDestroy() {
        super.onDestroy()
    }

}