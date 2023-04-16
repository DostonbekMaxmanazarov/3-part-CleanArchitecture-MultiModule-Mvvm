# 2-Part. MultiModule
#### *Separation of concerns, Recommended app architecture and MultiModule. This project is simply a user authorization project.*

> #### *Siz ko'rib turgan projectimda, authorization uchun simple project qilingan. Ma'lumotlarni saqlash uchun SharedPreferencedan foydalanilgan. Bunda oddiygina yondashilgan, Design patternlar va Dependency Injection framworklaridan foydalanilmasdan clean architecturaga kirish qilganman, chunki vazifamiz layerlarga ajratish va projectni multi modulega o'tkazish.*

<img width="360" height="480" alt="Screen Shot 2023-04-15 at 12 39 23" src="https://user-images.githubusercontent.com/77477995/232196444-59a98ce5-09ec-40da-92d2-13bdc71fe96c.png"> <img hspace="20" width="360" height="480" alt="Screen Shot 2023-04-15 at 15 39 23" src="https://user-images.githubusercontent.com/77477995/232209051-b7a4d0ab-223e-4063-b4d0-6a02d33a270c.png">

:relaxed: ***Multi module ning foydali tomonlari!***

- Modullashtirish orqali projectni ko'plab kichik mustaqil modullarga ajratish imkonini beradi. Bu kodni saqlash, yangilash, o'zgartirishni osonlashtiradi, shuningdek uni testdan o'tkazishni osonlashtirishi mumkin.
- (UI, Business, Data va boshqa) concernlarni yaxshi ajratish
- Projectdan qayta foydalanish, multimodule kod yordamida biz kodni bir nechta projectda yoki modullarda osongina qayta ishlatishimiz mumkin, bu vaqtni tejash va xatolik xavfini kamaytirish imkonini beradi.
- Katta jamoa dasturchilari birgalikda ishlashi osonlashtiradi, chunki ular bir-birining kodlariga aralashmasdan turli modullarda ishlashi mumkin.
- Build time ning tezroq bo'lishi, multimodule yordamida biz butun projectni qayta build qilish o'rniga faqat o'zgargan modullarni qayta build qilishimiz mumkin. Bu katta loyihalar uchun build vaqtini sezilarli darajada qisqartirishi mumkin.
- Soddalashtirilgan dependencylarni boshqarish: Multimodule bizga dependencylarni yanada samarali boshqarishga yordam beradi.

:monocle_face: ***Barcha projectlarimizni modulelashtirishimiz kerakmi?***
- Agar biz kichik project ustida ishlayotgan bo'lsak, va kichik darajadagi xususiyatlarga ega bo'lgan project bo'lsa, va tezroq bitirishimiz kerak bo'lsa, multimoduledan foydalanmaganimiz maqul.
Chunki hamma narsani sozlash va saqlash uchun ko'proq vaqt kerak bo'ladi, lekin biz projectni tezroq ishga tushirishimiz kerak. Shuningdek project ustida ishlayotgan 1 yoki 2 Android dasturchisilaridan iborat jamoalar uchun bu ortiqcha ish bo'lishi mumkin. 

:monocle_face: ***Shuning uchun uni qachon ishlatish kerak?***
- Boshidan katta bo'lgan va kelajakda yanada kengayishi mumkin bo'lgan projectlarda.
- Boshqa loyihalardagi bazi modullarni yoki funksiyalarni ishlatishimiz kerakligini bilganimizda.
- Agar bitta projectda 3 tadan ortiq dasturchilar ishlaganda.

> Umuman olganda, Android proektimizda multimoduledan foydalanish yanada tartibli va samarali, shuningdek kodni yaxshiroq qayta ishlatishga olib keladi.

**```Eslatma!```**
Ushbu proektimda faqatgina layerlarga ajratilgan va multi modulega o'tkazilgan, bunda classlar qo'lda kiritilgan. Dependency injection frameworklaridan va design patternlar(Mvvm, Mvp...) dan foydalanilmagan, sababi clean architecturani tushunish uchun bu yo'lni tanlaganman, chunki dependencylarni qo'lda kiritish qanchalik noqulat va murakkablashib ketishini ko'rishimiz mumkin, bu yo'l orqali dependency injection texnologiyalarni yaxshi tushunib olishimizni nazarda tutganman, Bunda design patternlarning ham proektimizdagi o'rnini bilib olishimiz mumkin. Clean architectura uchun kerakli bo'lgan texnologiyalarni qadam va qadam github repositoryamdan ko'rishingiz mumkin.
