package day57;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

public class MVC {
}
// ---- MVC1 ---- //
class ViewController{ }
class Dao{}

// ---- MVC2 ---- //
class Mvc2View{}
class Mvc2Controller{}
class Mvc2Dao{}

// ---- MVC2 3티어 ---- //
// view : resource 안에 (html/css/js) 존재
class Mvc2tier3Controller{}
class Mvc2tier3Service{}
class Mvc2tier3Dao{}

// ---- Spring MVC2-3Tier ---- //
@RestController
class Controller{}
@Service
class MvcService{}
@Component
class MvcDao{}














