<script>
	import { goto } from '@sapper/app'
	import { faSignOutAlt } from '@fortawesome/free-solid-svg-icons/faSignOutAlt'
	import { faLock } from '@fortawesome/free-solid-svg-icons/faLock'
	import { faWrench } from '@fortawesome/free-solid-svg-icons/faWrench'
	import { faCaretDown } from '@fortawesome/free-solid-svg-icons/faCaretDown'
	import { faUser } from '@fortawesome/free-solid-svg-icons/faUser'

	import MenuItem from './MenuItem.svelte'
	import Icon from '../Icon.svelte'

	import auth from '../auth/auth-store.js'
	import authService from './../auth/auth-service.js'
	let isOpen = false

	function logout() {
		authService
			.logout()
			.then(() => {
				auth.logout()
				return auth.loadUserIfAuthenticated()
			})
			.then(() => goto('/'))
			.catch()
	}
</script>

<div class="px-2 pt-2 pb-4 sm:p-0 relative sm:flex sm:mr-2 sm:z-10">
	<div
		class="px-2 py-1 sm:py-0 flex justify-start items-center rounded
			sm:rounded-none font-semibold hover:text-white hover:bg-gray-700
			sm:hover:bg-transparent focus:outline-none focus:ring focus:ring-primary-500"
	>
		<button
			aria-label="Account Menu"
			data-test="svlAccountLink"
			on:click="{() => (isOpen = !isOpen)}"
			class="sm:z-10 sm:h-8 sm:w-8 sm:flex sm:justify-center
				sm:items-center sm:rounded-full sm:overflow-hidden border-0
				sm:border-2 sm:border-gray-600 text-gray-400 focus:text-white
				focus:outline-none focus:border-white focus:ring focus:ring-primary-500"
		>
			<Icon icon="{faUser}" />
			<span class="sm:hidden">{$auth.login}</span>
			<span class="sm:absolute sm:pl-12">
				<Icon icon="{faCaretDown}" />
			</span>
		</button>
	</div>
	{#if isOpen}
		<button
			tabindex="-1"
			on:click="{() => (isOpen = false)}"
			class="fixed hidden sm:block inset-0 w-full h-full bg-gray-400
				opacity-50 cursor-default"></button>
	{/if}
	<div
		class:hidden="{!isOpen}"
		class="sm:absolute sm:right-0 sm:mt-10 sm:w-48 py-2 sm:bg-white sm:dark:bg-gray-700 rounded
			sm:rounded-lg sm:shadow-lg"
	>
		<MenuItem
			testId="svlChgPwdLink"
			link="/account/password"
			on:click="{() => (isOpen = false)}"
			><Icon classes="sm:mr-1" icon="{faLock}" />
			Change Password
		</MenuItem>
		<MenuItem
			testId="svlSettingsLink"
			link="/account/settings"
			on:click="{() => (isOpen = false)}"
			><Icon classes="sm:mr-1" icon="{faWrench}" />
			Settings
		</MenuItem>
		<MenuItem testId="svlSignoutLink" link="/" on:click="{logout}"
			><Icon classes="sm:mr-1" icon="{faSignOutAlt}" />
			Sign out
		</MenuItem>
	</div>
</div>
