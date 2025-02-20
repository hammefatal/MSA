package home.hammefatal.msa.userservice;

import home.hammefatal.msa.userservice.application.port.in.SearchUserCommand;
import home.hammefatal.msa.userservice.application.port.out.FindUserPort;
import home.hammefatal.msa.userservice.application.service.FindUser;
import home.hammefatal.msa.userservice.domain.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class UserServiceApplicationTests {

    @InjectMocks
    private FindUser findUserService;

    @Mock
    private FindUserPort findUserPort;

    @BeforeEach
    public void setup() {
        // @InjectMocks 가 포함된 클래스에 @Mock 들을 주입시켜준다.
        MockitoAnnotations.openMocks(this);

        /*
         private final 의 경우 setter 를 통해 주입할 수 없기 때문에
         Reflection or Constructor 를 통해 주입해야 한다.
         */
        findUserService = new FindUser(findUserPort);
    }

    @Test
    public void test() {
        System.out.println("Hello,Test");
        System.out.println("findUserService = " + findUserService);
    }

    private static Stream<SearchUserCommand> provideSearchUserCommand() {
        return Stream.of(
                SearchUserCommand.builder()
                        .email("userOne")
                        .build()
        );
    }

    @ParameterizedTest
    @MethodSource("provideSearchUserCommand")
    public void testFindUserServiceWhenNoContents(SearchUserCommand testCommand) {
        // 1. 예상 결과 정의
        int expectedResult = 1;

        // 2. Mocking 을 위한 dummy data 생성


        // 3. 예상 결과를 위해 Mocking
        when(findUserPort.getUser(1L).isPresent())
                .thenReturn(true);

        // 4. Mocking 된 mock 들을 사용해서 테스트 진행
        List<User> foundUsers = findUserService.searchUsers(testCommand);

        // 5. Verify 를 통해 테스트가 잘 진행되었는지 확인
        //verify(findUserPort, times(1)).searchUsers();

        // 6. Assert 를 통해 최종 확인
        assertEquals(expectedResult, foundUsers.size());
    }

}
