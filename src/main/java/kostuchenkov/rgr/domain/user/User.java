package kostuchenkov.rgr.domain.user;

import kostuchenkov.rgr.domain.Review;
import kostuchenkov.rgr.domain.product.Product;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String login;
    private String password;
    private String email;
    private String firstName;
    private String secondName;
    private String patronymic;
    private String contactInfo;
    private Date birthday;
    private int balance;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    @ManyToMany
    @JoinTable(name = "cart",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> cart;

    @ManyToMany
    @JoinTable(name = "wishlist",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> wishlist;

    @Enumerated(EnumType.STRING)
    private UserWishlistAccess wishlistAccess;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public Date getBirthday() {
        return birthday;
    }

    public int getBalance() {
        return balance;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public void setWishlistAccess(UserWishlistAccess wishlistAccess) {
        this.wishlistAccess = wishlistAccess;
    }

    public UserStatus getStatus() {
        return status;
    }

    public UserWishlistAccess getWishlistAccess() {
        return wishlistAccess;
    }
}