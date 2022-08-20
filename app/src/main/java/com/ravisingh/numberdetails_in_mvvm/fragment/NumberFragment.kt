package com.ravisingh.numberdetails_in_mvvm.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ravisingh.numberdetails_in_mvvm.R
import com.ravisingh.numberdetails_in_mvvm.databinding.FragmentNumberBinding
import com.ravisingh.numberdetails_in_mvvm.local.NumberViewModel
import com.ravisingh.numberdetails_in_mvvm.util.Status
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NumberFragment : Fragment() {

    lateinit var binding: FragmentNumberBinding
    val viewModel: NumberViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentNumberBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.fetchData.setOnClickListener {
            val number = binding.numberEt.text.toString().trim().toInt()
            viewModel.getNumberFact(number)
        }

        viewModel.fact.observe(viewLifecycleOwner) {
            when (it?.getContentIfNotHandled()?.status) {

                Status.LOADING -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                Status.ERROR -> {
                    binding.progressBar.visibility = View.GONE
                }

                Status.SUCCESS -> {
                    binding.progressBar.visibility = View.GONE
                    binding.numberFact.text = it.peekContent().data?.text
                }
                else -> {}
            }
        }

    }
}