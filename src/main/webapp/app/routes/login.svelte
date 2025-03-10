<script>
	import { goto } from '@sapper/app'

	import appLogo from './../components/svg/appLogo.svg'
	import Alert from './../components/Alert.svelte'
	import Button from '../components/Button.svelte'
	import InputControl from '../components/InputControl.svelte'
	import CheckboxControl from '../components/CheckboxControl.svelte'

	import auth from './../components/auth/auth-store.js'
	import authService from './../components/auth/auth-service.js'

	let username
	let password
	let rememberMe = false
	let authError = false
	let validUsername = false
	let validPassword = false

	$: validForm = validUsername && validPassword

	function login() {
		authError = false

		authService
			.login(username, password, rememberMe)
			.then(() => auth.loadUser())
			.then(() => goto('/'))
			.catch(() => ((password = ''), (authError = true)))
	}
</script>

<svelte:head>
	<title>Sign in to SampleBlogApp</title>
	<meta name="Description" content="Sign in to SampleBlogApp" />
</svelte:head>

<section class="flex h-screen items-start justify-center">
	<div class="p-4 w-full sm:w-[450px] mx-4 sm:m-0">
		<div class="px-4 py-3 mt-4 sm:mx-0 flex justify-center">
			<div class="w-3/4 dark:text-primary-100">
				<img src="{appLogo}" alt="Application Logo" />
			</div>
		</div>
		<div
			data-test="signInTitle"
			class="mt-4 px-4 w-full text-3xl text-center"
		>
			Sign in to SampleBlogApp
		</div>
		<Alert data-test="errorMsg" type="danger" show="{!!authError}">
			Incorrect username or password.
		</Alert>
		<form
			data-test="loginForm"
			class="mt-4 p-4 flex flex-col bg-white dark:bg-gray-800 border border-gray-200 dark:border-gray-700 shadow-md rounded"
		>
			<InputControl
				id="username"
				label="Username"
				name="username"
				value="{username}"
				on:input="{event => (username = event.target.value)}"
				required
				validations="{[
					{ type: 'required', message: 'Username is mandatory' },
				]}"
				on:validate="{event => (validUsername = event.detail.valid)}"
			/>

			<InputControl
				id="password"
				type="password"
				label="Password"
				name="password"
				value="{password}"
				on:input="{event => (password = event.target.value)}"
				required
				validations="{[
					{ type: 'required', message: 'Password is mandatory' },
				]}"
				on:validate="{event => (validPassword = event.detail.valid)}"
			/>

			<div class="mt-1 mb-2 ml-1">
				<CheckboxControl
					name="rememberMe"
					checked="{rememberMe}"
					on:change="{event => (rememberMe = event.target.checked)}"
					>Remember me</CheckboxControl
				>
			</div>

			<Button type="submit" on:click="{login}" disabled="{!validForm}">
				Sign in
			</Button>
		</form>
		<div
			class="mt-5 px-4 flex justify-between text-primary-700 dark:text-primary-500"
		>
			<div>
				<a
					data-test="forgotPwdLink"
					href="/account/reset/init"
					class="font-semibold">Forgot password?</a
				>
			</div>
			<div>
				<a
					data-test="registerLink"
					href="/account/register"
					class="font-semibold">Create an account</a
				>
			</div>
		</div>
	</div>
</section>
