package com.watasolutions.week7_t7.screens.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.watasolutions.week7_t7.R
import com.watasolutions.week7_t7.app.ListAdapter
import com.watasolutions.week7_t7.databinding.FragmentLoginBinding
import com.watasolutions.week7_t7.model.User


/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    lateinit var binding: FragmentLoginBinding
    lateinit var viewModel: UserViewModel
    lateinit var adapter : ListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ListAdapter()
        binding.rvUser.layoutManager = LinearLayoutManager(context)
        binding.rvUser.adapter = adapter
        registerSaveSuccess()
        binding.btnSave.setOnClickListener {
            val username = binding.tvUsername.editText?.text.toString().trim()
            val pass = binding.tvPassword.editText?.text.toString().trim()
            val user = User(username,pass)
            viewModel.addUser(user)
        }
        binding.btnLoad.setOnClickListener {
            adapter.setData(viewModel.loadData())
        }
    }

    private fun registerSaveSuccess(){
        viewModel.saveEventSuccess.observe(viewLifecycleOwner){
            when(it) {
                true -> {
                    binding.tvUsername.editText?.setText("")
                    binding.tvPassword.editText?.setText("")
                }
            }
        }
    }


}