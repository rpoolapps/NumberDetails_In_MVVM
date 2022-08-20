package com.ravisingh.numberdetails_in_mvvm.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ravisingh.numberdetails_in_mvvm.local.response.NumberResponse
import com.ravisingh.numberdetails_in_mvvm.util.Events
import com.ravisingh.numberdetails_in_mvvm.util.Result
import com.ravisingh.numberdetails_in_mvvm.util.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NumberViewModel @Inject constructor(private val repo: NumberRepo) : ViewModel() {

    private val _fact = MutableLiveData<Events<Result<NumberResponse>>>()
    val fact: LiveData<Events<Result<NumberResponse>>> = _fact

    fun getNumberFact(number: Int) = viewModelScope.launch {
        _fact.postValue(Events(Result(Status.LOADING, null, null)))
        _fact.postValue(Events(repo.getNumberFact(number)))
    }
}