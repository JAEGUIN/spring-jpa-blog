package com.jaeguinblog.I.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaeguinblog.I.model.RoleType;
import com.jaeguinblog.I.model.User;
import com.jaeguinblog.I.repository.UserRepository;


@RestController
public class DommyControllerTest {
	
	@Autowired  //의존성 주입(DI)
	private UserRepository userRepository;
	//이건 null인데 오토와이어드로 자동 연결됨.
	
	@GetMapping("/dummy/users")
	public List<User> list() {
		return userRepository.findAll();
	}
	
	//한 페이지당 2건에 데이터를 받아 리턴
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC) Pageable pageable){
		Page<User> pagingUser = userRepository.findAll(pageable);
		
		List<User> users = pagingUser.getContent();
		return users;
	}
	
	//{id}주소로 파라메터를 전달 받을 수 있음.
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		//user/4를 찾으면 내가 db에서 못 찾아오게 되면 user null이 될거임
		//그럼 return null이 리턴이 되니 프로그램에 문제 발생
		//Optional로 너의 User객체를 감싸서 가져올테니 null인지 아닌지 판단해서 return 해!!
		
//		User user = userRepository.findById(id).orElseGet(new Supplier<User>() {
//			@Override
//			public User get() {
//				// TODO Auto-generated method stub
//				return null;
//			}			
//		});
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				return new IllegalArgumentException("해당 사용자가 없습니다.");
			}
		});
		// 요청 : 웹브라우저
		// user 객체 = 자바 오브젝트
		// 변환 ( 웹브라우저가 이해할 수 있는 데이터) -> json (Gson 라이브러리)
		// 스프링부트 = MessageConverter라는 애가 응답시에 자동 작동
		// 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서
		// user 오브젝트를 json으로 변환해서 브라우저에게 던져줍니다.
		return user;	
		
	}
	
			
	
	//로컬/blog/dummy/join으로 (요청)
	//http의 body에 이름,비번,이메일 가지고 (요청)
	//key=value로 값이 입력됨.
	
//	public String join(String username, String password, String email) {
//		System.out.println("username: "+username);
//		System.out.println("password: "+password);
//		System.out.println("email: "+email);
//			
//		return "회원가입완료";
//	}
	//user user같은 오브잭트로 받아서 처리(ctrl + shift + o 로 improt)
	@PostMapping("/dummy/join")
	public String join(User user) {
		System.out.println("id: "+user.getId());
		System.out.println("username: "+user.getUsername());
		System.out.println("password: "+user.getPassword());
		System.out.println("email: "+user.getEmail());
		System.out.println("role: "+user.getRole());
		System.out.println("createDate: "+user.getCreateDate());
			
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입완료";
	}
	//이상태에서 db insert를 받기 위해서 새로운 패키지가 필요!

}
