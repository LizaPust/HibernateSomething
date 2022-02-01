import javax.persistence.*;

@Entity
@Table(name = "Orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(insertable = false, updatable = false)
    private int Client_Id;

    @Column(name = "Item_name")
    private String name;

    @Column(name = "Item_price")
    private String price;

    @ManyToOne
    @JoinColumn (name="Client_Id", referencedColumnName = "id")
    private Client client;

    public Integer getId() {
       return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }


    @Override
   public String toString() {
        return "Clients [id=" + id + ", name=" + name + ", price=" + price + "]";
    }

}
