package io.customerly.entity

/*
 * Copyright (C) 2017 Customerly
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.support.annotation.IntDef
import io.customerly.BuildConfig

/**
 * Created by Gianni on 09/09/16.
 * Project: Customerly Android SDK
 */

@ErrorCode private const val ERROR_CODE__CUSTOMERLY_NOT_CONFIGURED = 1
@ErrorCode const val ERROR_CODE__IO_ERROR = 2
@ErrorCode const val ERROR_CODE__HTTP_REQUEST_ERROR = 3
@ErrorCode const val ERROR_CODE__HTTP_RESPONSE_ERROR = 4
@ErrorCode const val ERROR_CODE__GLIDE_ERROR = 5
@ErrorCode const val ERROR_CODE__ATTACHMENT_ERROR = 6
@ErrorCode const val ERROR_CODE__GENERIC = 7

@IntDef(ERROR_CODE__CUSTOMERLY_NOT_CONFIGURED, ERROR_CODE__IO_ERROR, ERROR_CODE__HTTP_REQUEST_ERROR, ERROR_CODE__HTTP_RESPONSE_ERROR, ERROR_CODE__GLIDE_ERROR, ERROR_CODE__ATTACHMENT_ERROR, ERROR_CODE__GENERIC)
@Retention(AnnotationRetention.SOURCE)
internal annotation class ErrorCode

internal fun clySendUnconfiguredError() {
    clySendError(errorCode = ERROR_CODE__CUSTOMERLY_NOT_CONFIGURED, description = BuildConfig.CUSTOMERLY_SDK_NAME + "is not configured")
}

internal fun clySendError(@ErrorCode errorCode : Int, description : String, throwable : Throwable? = null) {
    val stacktraceDump = (throwable?.stackTrace ?: Thread.currentThread().stackTrace)
            .fold(StringBuilder(), { sb, ste ->
                sb.append(ste.toString()).append('\n')
            }).also {
                it.setLength(it.length - 1)
            }.toString()

    //TODO API
//    IApi_Request.Builder<Void>(IApi_Request.ENDPOINT_REPORT_CRASH)
//            .param("error_code", errorCode)
//            .param("error_message", description)
//            .param("fullstacktrace", stacktraceDump)
//            .opt__ReportingErrorDisabled()
//            .start()

    //TODO LOG
//    Customerly.get()._log("Error sent -> code: $errorCode ||| message: $description ||| stack:\n$stacktraceDump")
}