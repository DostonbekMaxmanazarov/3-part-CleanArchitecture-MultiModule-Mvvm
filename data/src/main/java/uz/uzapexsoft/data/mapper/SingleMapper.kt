package uz.uzapexsoft.data.mapper

fun interface SingleMapper<T, R> {
    operator fun invoke(value: T): R
}