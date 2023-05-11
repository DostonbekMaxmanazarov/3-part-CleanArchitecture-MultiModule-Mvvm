# 3-part-CleanArchitecture-MultiModule-Mvvm
Project: This project is simply a user authorization project". Contained: Recommended app architecture, MultiModule, Mvvm.

> Siz ko'rib turgan projectim clean architecturaning 3-qismi hisoblanadi, authorization uchun simple project qilingan. Ma'lumotlarni saqlash uchun SharedPreferencedan foydalanilgan. Dependency Injection framworklaridan foydalanilmasdan clean architecturaga bosqichma bosqich o'tmoqdaman, va bu qismda mvvm patternni qo'shganman. Proekt claen architectura layerlariga ajratilgan, multi modulga o'tkazilgan va mvvm patterndan foydalanilgan.*

<img width="360" height="480" hspace="20" alt="Screen Shot 2023-05-02 at 15 02 13" src="https://user-images.githubusercontent.com/77477995/235638281-48b4323e-e382-4939-825a-b3659a07428b.png"> <img width="360" height="480" hspace="20" alt="Screen Shot 2023-05-02 at 14 59 02" src="https://user-images.githubusercontent.com/77477995/235638449-e8c96c96-eb9a-40ec-8b4d-2d9fa6863390.png">

:monocle_face: ***Nega bizga bu pattern kerak?*** Bitta activity yoki fragmentga hamma narsani qo'shish kodni test qilib ko'rish va qayta ishlashda muammolarga olib keladi. Shuning uchun kodni ajratish va clean architekturadan foydalanish tavsiya etiladi.

MVVM qisqartmasi Model, View, ViewModel.

- Model : Bu ilova ma'lumotlarini saqlaydi. Va view bilan bevosita gaplasha olmaydi. Odatda, ma'lumotlarni ViewModel-ga Observable qilish orqali ko'rsatish tavsiya etiladi.
- View : U har qanday Ilova logikasidan mahrum bo'lgan ilovaning UI qismini ifodalaydi. U ViewModelni kuzatadi.
- ViewModel : Model va view o'rtasida bog'lovchi vazifasini bajaradi. U Modeldagi ma'lumotlarni o'zgartirish uchun javobgardir. Viewga ma'lumotlar oqimini beradi. Shuningdek, u Viewni yangilash uchun observe yoki callbacklardan foydalanadi. U Modeldan ma'lumotlarni so'raydi.

![MVVMPattern](https://user-images.githubusercontent.com/77477995/235659727-9ec3ab26-0081-45bc-a5a5-fb602ebe2631.png)


**```ViewModel```** - bu activity yoki fragment uchun ma'lumotlarni tayyorlash va boshqarish uchun javobgar bo'lgan class. Shuningdek viewmodel applicationning qolgan qismi(biznes logika classlari) bilan Activity/Fragment aloqasini boshqaradi. ViewModel har doim (fragment yoki activity) scope bilan bog'langan holda yaratiladi va scope mavjud ekan, viewmodel saqlanib qoladi. Masalan activity tugaguniga qadar viewmodel saqlanib turadi. Boshqacha qilib aytganda, agar konfiguratsiyani o'zgartirish (masalan, rotation) uchun owner yo'q qilingan bo'lsa, ViewModel yo'q qilinmasligini anglatadi. Yangi owner instance faqat mavjud viewmodelga qayta ulanadi. ViewModel-ning maqsadi - Activity yoki Fragment uchun zarur bo'lgan ma'lumotlarni olish va saqlashdir. Activity yoki Fragment ViewModeldagi o'zgarishlarni kuzata olishi kerak ya’ni observe qilib turish kerak. ViewModels odatda ushbu ma'lumotlarni LiveData yoki Android DataBinding orqali observe bo’lishi uchun foydalaniladi. ViewModelning yagona mas'uliyati UI uchun ma'lumotlarni boshqarishdir. U hech qachon view ierarxiyasiga kirmasligi yoki Activity yoki Fragmentga reference ushlab turmasligi kerak.

```kotlin
public class MyFragment extends Fragment {
       public void onStart() {
           UserModel userModel = new ViewModelProvider(requireActivity()).get(UserModel.class);
       }
   }
```

ViewModel odatda viewning ma'lumotlari va xatti-harakatlarini qamrab oluvchi class. Masalan, Android applicationda ViewModel appning ma'lum bir ekrani uchun ma'lumotlarni va logikani o'z ichiga olgan class sifatida ishlatilishi mumkin. ViewModel ma'lumotlarning qanday saqlanishi va boshqarilishini yashirish bilan birga, ma'lumotlarni ko'rsatish va ma'lumotlar bilan ishlashda ekran foydalanishi mumkin bo'lgan xususiyatlar va methodlarni ochib beradi.

ViewModel-dan foydalanishning asosiy afzalliklaridan biri shundaki, u viewning va data layerning **```concernlarini```** ajratishga yordam beradi, bu kodni yanada modulli qilish va saqlashni osonlashtiradi.

**```ViewModelProvider```** - bu Scope uchun ViewModellarni ta'minlovchi class hisoblanadi. Activity yoki Fragment uchun Default ViewModelProvider  uni konstruktorga uzatish orqali olinishi mumkin: ViewModelProvider(myFragment)
1. ViewModelProvider-ni yaratish. Bu ViewModellar-ni yaratadi va ularni berilgan ViewModelStoreOwner storega saqlaydi. Agar owner HasDefaultViewModelProviderFactory-ni qo'llasa, bu method default factorydan foydalanadi. Aks holda, NewInstanceFactory ishlatiladi.

```kotlin
public constructor(
    owner: ViewModelStoreOwner
) : this(owner.viewModelStore, defaultFactory(owner), defaultCreationExtras(owner))
```
2. ViewModelProvider-ni yaratish, u berilgan factory orqali ViewModellarni yaratadi va ularni berilgan ViewModelStoreOwner storega saqlaydi.
Params: owner - ViewModelStoreOwner uning ViewModelStore-dan ViewModellarni saqlash uchun foydalaniladi.
factory - yangi ViewModellarni yaratish uchun foydalaniladigan factory.

```kotlin
public constructor(owner: ViewModelStoreOwner, factory: Factory) : this(
    owner.viewModelStore,
    factory,
    defaultCreationExtras(owner)
)
```



