package com.sinapsisenergia.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sinapisienergia.entity.Subestacao;
import com.sinapsisenergia.repository.SubestacaoRepository;

@RestController
@RequestMapping("/subestacao")
@ResponseBody
public class SubestacaoController {

		@Autowired
		SubestacaoRepository subestacaoRepository;
		
		
		
		@GetMapping
		public List<Subestacao> listarTodos(){
			return subestacaoRepository.findAll();
		}
		
	 
		@PostMapping("/salvar")
		public ResponseEntity<?> cadastrarSubestacao(@RequestBody Subestacao subestacao){
			try {
				Subestacao subestacaoResposta = subestacaoRepository.save(subestacao);
				
				if(subestacaoResposta == null) {
					throw new Exception("Dados não foram salvos");
				}
				return ResponseEntity.status(200).body(subestacaoResposta);
				
			}catch(Exception ex){
				Map<String, String> mapa = new HashMap<String, String>();
				
				mapa.put("Erro", "Erro na gravação" + ex.getMessage());
				
				return ResponseEntity.status(500).body(mapa);
				
			}
		}
		
		@GetMapping("/{idsubestacao}")
		public ResponseEntity<Subestacao> acharSubestacaoPorId(@PathVariable Long idsubestacao){
			return subestacaoRepository.findById(idsubestacao).map(subestacaoResposta -> ResponseEntity.ok().body(subestacaoResposta)).
					orElse(ResponseEntity.notFound().build());
		}
		
		
		@DeleteMapping("/deletar/{idSubestacao}")
		public void excluindoSub(@PathVariable Long idSubestacao){
				
			subestacaoRepository.deleteById(idSubestacao);	
			
		}
		
		@PutMapping("/alterar")
		public Subestacao atualizarSubestacao(@RequestBody Subestacao subestacao) {
			subestacaoRepository.findById(subestacao.getIdSubestacao()).orElse(null);
		
			
			return subestacaoRepository.save(subestacao);
			 
		}
		
			 
			 
		
		
				
		
		
		
		
		
		
}
