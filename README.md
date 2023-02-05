# Jetpack Compose A11Y Extensions

An Android library that adds missing functionality to Jetpack Compose to help build accessible UIs.

## `Modifier` extensions

### `Modifier.tappable`

Allows a composable to become clickable without merging descendents and applying any semantic properties.

```kotlin
Modifier.tappable(
    onTap = { println("I was tapped") },
)
```

This extension is handy when you want to manually control how a composable and its children can be clicked by somone using a variety of input mechanisms (i.e. touchscreen, keyboard, screen reader).

### `Modifier.optionable`

Determines whether `Modifier.selectable` or `Modifier.toggleable` should be applied to a composable based on the `Role` provided to it.

```kotlin
Modifier.optionable(
    role = Role.RadioButton,
    selected = true,
    onClick = { println("Selected state is now: $it" ) }
)
```

The following table outlines how each `Role` maps to the applied modifier:

|`Role`|Applied modifier|
|--|--|
|`Role.RadioButton`|`Modifier.selectable`|
|`Role.Tab`|`Modifier.selectable`|
|`Role.Checkbox`|`Modifier.toggleable`|
|`Role.Switch`|`Modifier.toggleable`|
|Other roles|`IllegalArgumentException` thrown|

This extension is handy when dynamically generating a list of options that can either be radio buttons or checkboxes depending on some external factor (i.e. a form generated based on an API response).

### `Modifier.optionableGroup` and `Modifier.optionalGroupItem`

These can be used to create a group of related options (i.e. radio group, checkbox group, tab group). Unlike `Modifier.selectableGroup`, this works for any type of input in both lazy and non-lazy layouts.

```kotlin
// Grouping related checkboxes together
Column(modifier = Modifier.optionableGroup(size = 3)) {
    Checkbox(modifier = Modifier.optionableGroupItem(index = 0))
    Checkbox(modifier = Modifier.optionableGroupItem(index = 1))
    Checkbox(modifier = Modifier.optionableGroupItem(index = 2))
}
```

### `Modifier.clickableButton`

A wrapper for `Modifier.clickable` that defaults the role of the composable to `Role.Button`. When a composable can be clicked, a role must be set so that screen reader users know what type of control they are interacting with.

```kotlin
Row(modifier = Modifier.clickableButton(onClick = { println("I was clicked!") })) {
    Text("My custom button")
}
```
