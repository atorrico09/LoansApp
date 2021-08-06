package com.atorrico.loansapp.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ConcatAdapter
import com.atorrico.loansapp.R
import com.atorrico.loansapp.data.model.LoanItem
import com.atorrico.loansapp.data.model.Result
import com.atorrico.loansapp.data.source.LoanRepository
import com.atorrico.loansapp.data.source.local.LoanLocalDataSource
import com.atorrico.loansapp.databinding.LoanFragmentBinding
import com.atorrico.loansapp.ui.adapters.BadgeAdapter
import com.atorrico.loansapp.ui.adapters.ExtrasAdapter
import com.atorrico.loansapp.ui.adapters.StatusAdapter
import com.atorrico.loansapp.ui.adapters.StoryAdapter

class LoanFragment : Fragment(R.layout.loan_fragment), StatusAdapter.StatusListener {

    private val viewModel: LoanViewModel by viewModels {
        LoanViewModel.Factory(
            LoanRepository(
                LoanLocalDataSource(requireContext())
            )
        )
    }
    private lateinit var binding: LoanFragmentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = LoanFragmentBinding.bind(view)

        viewModel.getLoan().observe(viewLifecycleOwner, resultObserver)
    }

    private val resultObserver: Observer<Result<LoanItem>> =
        Observer { loanResponse ->
            when (loanResponse) {
                is Result.Loading -> {
                    showLoading()
                }
                is Result.Success -> {
                    hideLoading()
                    setValues(loanResponse.data)
                }
                is Result.Error -> {
                    hideLoading()
                    showError(loanResponse.exception?.message.toString())
                }
            }
        }

    private fun setValues(loanItem: LoanItem) {
        val listOfAdapters = listOf(
            StatusAdapter(loanItem, this),
            BadgeAdapter(loanItem),
            StoryAdapter(),
            ExtrasAdapter(R.drawable.ic_email, R.string.extras_invite),
            ExtrasAdapter(R.drawable.ic_help, R.string.extras_faq)
        )

        val concatAdapter = ConcatAdapter(listOfAdapters)
        binding.rvLoan.adapter = concatAdapter
    }

    //TODO: show custom animated loading and error
    private fun showError(err: String) =
        Toast.makeText(requireContext(), err, Toast.LENGTH_LONG).show()

    private fun showLoading() =
        Toast.makeText(requireContext(), "startLoading", Toast.LENGTH_SHORT).show()

    private fun hideLoading() =
        Toast.makeText(requireContext(), "endLoading", Toast.LENGTH_SHORT).show()

    override fun onClick() {
        //TODO: implement click
        Toast.makeText(requireContext(), "click btn", Toast.LENGTH_SHORT).show()
    }

}