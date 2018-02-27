package br.com.fiap.notepadapi.controller

import br.com.fiap.notepadapi.model.Nota
import br.com.fiap.notepadapi.service.NotaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@CrossOrigin
@RequestMapping(value = "/nota")
class NotaController{
    @Autowired
    lateinit var notaService: NotaService
    @GetMapping
    fun buscarTodos(): List<Nota>{
        return notaService.buscarTodas()
    }
    @GetMapping(value = "/titulo/{titulo}")
    fun buscar(@PathVariable(value = "titulo") titulo: String): Nota{
        return notaService.buscar(titulo)
    }
    @PostMapping
    fun salvar(@RequestBody nota: Nota){
        notaService.salvar(nota)
        
    }
}