package com.devcourse.ycjung.user_register;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(User user, String rawPassword) {
        if (this.userRepository.countByUsername(user.getUsername()) > 0) {
            // throw new UserAlreadyRegisteredException(); 커스텀
            throw new RuntimeException();
        }

        user.setPassword(this.passwordEncoder.encode(rawPassword));
        this.userRepository.save(user);
    }
}
