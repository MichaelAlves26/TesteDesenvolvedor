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

import com.sinapisienergia.entity.RedeMt;
import com.sinapisienergia.entity.Subestacao;
import com.sinapsisenergia.repository.RedeMtRepository;

@RestController
@RequestMapping("/redemt")
@ResponseBody
public class RedeMtController{
	
	@Autowired
	RedeMtRepository redeMtRepository;
	
	@GetMapping
	public List<RedeMt> listarTodos(){
		return redeMtRepository.findAll();
	}
	
	@GetMapping("/{idRedeMt}")
	public ResponseEntity<RedeMt> acharSubestacaoPorId(@PathVariable Long idRedeMt){
		return redeMtRepository.findById(idRedeMt).map(redeResposta -> ResponseEntity.ok().body(redeResposta)).
				orElse(ResponseEntity.notFound().build());
		
	
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<?> salvarRede(@RequestBody RedeMt redeMt){
		try {
			RedeMt redeMtResposta = redeMtRepository.save(redeMt);
			
			if(redeMtResposta == null) {
				throw new Exception("Dados não foram salvos");
			}
			return ResponseEntity.status(200).body(redeMtResposta);
			
		}catch(Exception ex){
			Map<String, String> mapa = new HashMap<String, String>();
			
			mapa.put("Erro", "Erro na gravação" + ex.getMessage());
			
			return ResponseEntity.status(500).body(mapa);
			
		}
	}
	
	
	
	
	@DeleteMapping("/removerrede/{idRedeMt}")
	public void excluindoRede(@PathVariable Long idRedeMt) {
		
		redeMtRepository.deleteById(idRedeMt);
	}
	
	

	@PutMapping("/alterar")
	public RedeMt atualizarRede(@RequestBody RedeMt redeMt) {
		redeMtRepository.findById(redeMt.getIdRedeMt()).orElse(null);
	
		
		return redeMtRepository.save(redeMt);
		 
	}
	   
	

}
