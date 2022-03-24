
# Hepsiemlak Bootcamp Bitirme Projesi -Emlakburada uygulamasi

Kullanıcıların emlak sektöründe ilan yayınlayabildikleri web uygulamasıdır.

## Uygulama senaryosu

Kullanıcımız sisteme kayıtlıysa giriş yapar fakat sisteme kayıtlı değilse kullanıcı 
sisteme kayıt olur. Kayıt olduktan sonra bir login gerçeklesir. Kullanıcı ilanları 
görüntüleyebilir. Kullanıcı ilan yayınlamak istediginde paketi varsa ilan yayınlayabilir
fakat mevcut paketi yoksa ödeme yaptıgında yeni bir pakete sahip olabilir. Her paket 10
ilan yayınlama hakkı verir.


  
## API Kullanımı

# AUTH
#### Login olup JWT token elde et

```http
POST /auth 
```

# USERS
#### Bütün kullanıcıları getir
```http
GET /users 
```
#### Kullanıcı kaydet
```http
POST /users 
```

#### Kullanıcıyı sil
```http
DELETE /users/{id} 
```

#### İd ile kullanıcı getir
```http
GET /users/{id}
```

#### kullanıcı güncelle
```http
PUT /users 
```
#### kullanıcıya ürün ekle
```http
PUT /users/{userId}/products/{productId}
```
#### Kullanıcının paketlerini getir
```http
GET /users/packages-of-users/{userId}
```
# PRODUCTS 
#### Paket olusturmak
```http
POST /products 
```
# ADVERTS 
#### İlanları getir
```http
GET /adverts
```

#### İd ile ilan getir
```http
GET /adverts/{userId}
```

#### ilan güncelle
```http
PUT /adverts/{id}
```
#### İlanı sil
```http
DELETE /adverts/{id}
  
```
#### Kullanıcıya ait pasif ilanları getir
```http
GET /adverts/passive-adverts/{userId}
```

#### Kullanıcıya ait aktif ilanları getir
```http
GET /adverts/active-adverts/{userId}
```

#### İlanı aktif yap 
```http
PUT /adverts/make-active-advert/{advertId}
```
#### İlanı pasif yap 
```http
PUT /adverts/make-passive-advert/{advertId}
```
# PAYMENTS 
#### Ödeme yap
```http
POST /payments
```

![Bitirme projesi drawio](https://user-images.githubusercontent.com/50759451/159806134-2ba400be-6108-4392-8e7c-f9051e3584be.png)
# Token olusturma ve login 
![image](https://user-images.githubusercontent.com/50759451/159813091-9082b19e-d436-4e20-8564-182ef44a80a7.png)
# Kullanıcıları getir
![image](https://user-images.githubusercontent.com/50759451/159813292-66b21c9d-730b-4c90-8319-b61bfbe9c343.png)
# Kullanıcıya ürün eklemek
![image](https://user-images.githubusercontent.com/50759451/159813399-4469e834-5301-403a-8a2b-fc35fe2efcde.png)
# Kullanıcının ürünü ödeme islemi 
![image](https://user-images.githubusercontent.com/50759451/159813774-a485c817-2aa2-4b56-847d-484d06ae0329.png)
# Kullanıcının ürünü ödeme islemi sonrası tanımlama ve  RabbitMq yazma islemi
![image](https://user-images.githubusercontent.com/50759451/159814011-4896745f-6856-462f-a852-7b990ed46c7c.png)
# Kullanıcı ilan eklerken statu "status": "IN_REVIEW" fakat asenkron bir sekilde statu "ACTIVE" cekilmistir
![image](https://user-images.githubusercontent.com/50759451/159817469-045cd937-2a58-4ae6-a2d7-b787ed228f29.png)





## Kullanılan Teknolojiler

**JAVA,** **Spring,** **Spring Security,** **JWT,** **MySql,** **Data Jpa,** **Hibernate,**
**Feign Client,** **RabbitMQ,** **Discovery Server,** **JUnit 5,** **Mikroservis,** **Restful,** 




  
