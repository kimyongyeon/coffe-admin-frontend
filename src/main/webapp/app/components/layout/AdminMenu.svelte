<script>
	import { faUsersCog } from '@fortawesome/free-solid-svg-icons/faUsersCog'
	import { faUsers } from '@fortawesome/free-solid-svg-icons/faUsers'
	import { faTasks } from '@fortawesome/free-solid-svg-icons/faTasks'
	import { faCaretDown } from '@fortawesome/free-solid-svg-icons/faCaretDown'

	import MenuItem from './MenuItem.svelte'
	import Icon from '../Icon.svelte'

	let isOpen = false
</script>

<div class="px-2 pt-2 pb-2 sm:p-0 relative sm:flex sm:mr-2">
	<div
		class="px-2 py-1 sm:py-0 flex justify-start items-center rounded sm:rounded-none font-semibold hover:text-white hover:bg-gray-700 sm:hover:bg-transparent focus:outline-none focus:ring focus:ring-primary-500"
	>
		<button
			aria-label="Administration Menu"
			data-test="svlAdminLink"
			on:click="{() => (isOpen = !isOpen)}"
			class="sm:h-8 sm:px-2 sm:w-auto sm:flex sm:justify-center focus:font-semibold sm:items-center sm:rounded border-0 text-gray-400 focus:text-white focus:outline-none focus:ring focus:ring-primary-500"
		>
			<span class="leading-none">
				<Icon classes="sm:mr-1" icon="{faUsersCog}" />
			</span>
			<span>Administration</span>
			<span>
				<Icon classes="ml-1" icon="{faCaretDown}" />
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
		class="sm:absolute sm:right-0 sm:mt-10 sm:w-48 py-2 sm:bg-white sm:dark:bg-gray-700 rounded sm:rounded-lg sm:shadow-lg"
	>
		<MenuItem
			testId="svlUserMgmtLink"
			link="/admin/user-management"
			on:click="{() => (isOpen = false)}"
		>
			<Icon classes="sm:mr-1" icon="{faUsers}" />
			User Management
		</MenuItem>
		<MenuItem
			testId="svlLoggerLink"
			link="/admin/logger"
			on:click="{() => (isOpen = false)}"
		>
			<Icon classes="sm:mr-1" icon="{faTasks}" />
			Loggers
		</MenuItem>
	</div>
</div>
