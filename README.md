
# Hepsiemlak Bootcamp Bitirme Projesi -Emlakburada uygulaması

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


  
## Kullanılan Teknolojiler

**JAVA,** **Spring,** **Spring Security,** **JWT,** **MySql,** **Data Jpa,** **Hibernate,**
**Feign Client,** **RabbitMQ,** **Discovery Server,** **JUnit 5,** **Mikroservis,** **Restful,** 




  
