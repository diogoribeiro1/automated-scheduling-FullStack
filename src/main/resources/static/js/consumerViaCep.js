'use strict'; 

const limparFormulario = (endereco) =>{
    document.getElementById('local').value = '';
    document.getElementById('bairro').value = '';
    document.getElementById('cidade').value = '';
}

const preencherFormulario = (endereco) => {
    document.getElementById('local').value = endereco.logradouro;
    document.getElementById('cidade').value = endereco.localidade;
    document.getElementById('bairro').value = endereco.bairro;
}

const eNumero = (numero) => /^[0-9]+$/.test(numero);

const cepValido = (cep) => cep.length == 8 && eNumero(cep); 

const pesquisarCep = async() => {
    limparFormulario();
	
	const myArray = document.getElementById('cep').value.split("-");
	const array1 = myArray[0];
	const array2 = myArray[1];
	const array = array1 + array2;
	console.log(array);
    const cep = array;
    const url = `http://viacep.com.br/ws/${cep}/json/`;

    if(cepValido(cep)){
        const dados = await fetch(url);
        const endereco = await dados.json();
    if(endereco.hasOwnProperty('erro')){
     document.getElementById('local').value = 'CEP não encontrado!';
    }else{
        preencherFormulario(endereco);
    }
    }else{
        document.getElementById('local').value = 'CEP não encontrado!';
    }
}

document.getElementById('cep')
        .addEventListener('focusout', pesquisarCep);