package com.ErickCoimbra.workshopmongo.config;




import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ErickCoimbra.workshopmongo.domain.Post;
import com.ErickCoimbra.workshopmongo.domain.User;
import com.ErickCoimbra.workshopmongo.dto.AuthorDTO;
import com.ErickCoimbra.workshopmongo.repository.PostRepository;
import com.ErickCoimbra.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	
	@Autowired
	private UserRepository userReposiroty;


	@Autowired
	private PostRepository postReposiroty;
	
	@Override
	public void run(String... arg0) throws Exception {

		userReposiroty.deleteAll();
		postReposiroty.deleteAll();

		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		Post post1 = new Post (null,sdf.parse("21/03/2018"),"Partiu viagem","Vou viajar pra Sao Paulo Abraços",new AuthorDTO(maria));
		Post post2 = new Post (null,sdf.parse("23/03/2018"),"Bom dia ","Acordi feliz hj",new AuthorDTO(maria));
		
		userReposiroty.saveAll(Arrays.asList(maria, alex, bob));
		postReposiroty.saveAll(Arrays.asList(post1,post2));
		
		
	}

}
