/*
 * package emlakburada.model;
 * 
 * import javax.persistence.Entity; import javax.persistence.GeneratedValue;
 * import javax.persistence.GenerationType; import javax.persistence.Id; import
 * javax.persistence.JoinColumn; import javax.persistence.ManyToOne; import
 * javax.persistence.Table;
 * 
 * import lombok.AllArgsConstructor; import lombok.Data; import
 * lombok.NoArgsConstructor;
 * 
 * @Data
 * 
 * @Entity
 * 
 * @NoArgsConstructor
 * 
 * @AllArgsConstructor
 * 
 * @Table(name="images") public class Image {
 * 
 * @Id
 * 
 * @GeneratedValue(strategy = GenerationType.IDENTITY) private int imageId;
 * 
 * private String imageUrl;
 * 
 * @ManyToOne
 * 
 * @JoinColumn(name="advert_id", nullable=false) private Advert advert;
 * 
 * 
 * 
 * 
 * 
 * }
 */