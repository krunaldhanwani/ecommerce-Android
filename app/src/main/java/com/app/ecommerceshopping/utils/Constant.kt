package com.app.ecommerceshopping.utils

class Constant {

    companion object {
        const val PICK_COUNTRY_CODE = 11
        var USERTOKEN: String = "USER_TOKEN"
        var FCM_TOKEN : String = "FCM_TOKEN"
        var TOKEN : String = "TOKEN"
        var UserID : String = "USER_ID"
        var EmailID : String = "EMAIL_ID"
        var Name : String = "NAME"
        var ProfilePhoto : String = "PROFILE_PHOTO"
        var Phone : String = "PHONE"
        var IMAGE : String = "IMAGE"
        var CountryCode : String = "COUNTRY_CODE"
        var Notification : String = "NOTIFICATION"
        var IsLogin : String = "islogin"
        var CURRENCY : String = "$"
        var PAGE_SIZE : String = "10"
        var STRIPE_PUBLISHABLE_KEY : String = "STRIPE_PUBLISHABLE_KEY"
        var STRIPE_SECRET_KEY : String = "STRIPE_SECRET_KEY"

        const val CAPTURE_IMAGE_CODE = 401
        const val ADD_NEW_ADDRESS = 501

        var MALE = "0"
        var FEMALE = "1"
        var OTHER = "2"
    }

    enum class CategoryType {
        Activities,
        Designers,
        Shopping,
        Restaurant,
        AccountCreate,
        Table,
        Home
    }

    enum class LoginType {

    }

    enum class VerificationType {
        NewRegistration,
        ForgotPassword,
        ResetPassword,
        ChangePassword
    }

    enum class AddressType {
        AddAddress,
        EditAddress
    }

    enum class PrivacyAndTerm {
        PrivacyPolicy,
        TermAndCondition
    }
}
