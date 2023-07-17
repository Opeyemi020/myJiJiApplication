package africa.semicolon.data.repository.mocks;

import africa.semicolon.data.models.User;;
import java.util.Optional;

public class DuplicateUserRepositoryMock extends FirstRegisterRepository {

    private Optional<User> findUserByUsername(String user){
        if (count()>=1){
            return Optional.of(new User());
        }
        return null ;
    }
}
